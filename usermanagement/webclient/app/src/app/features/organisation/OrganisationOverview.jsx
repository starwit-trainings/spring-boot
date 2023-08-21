import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import OrganisationRest from "../../services/OrganisationRest";
import {useHistory} from "react-router";
import {organisationOverviewFields} from "../../modifiers/OrganisationModifier";

function OrganisationOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const organisationRest = useMemo(() => new OrganisationRest(), []);
    const history = useHistory();
    const [organisationAll, setOrganisationAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        organisationRest.findAll().then(response => {
            setOrganisationAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/organisation/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/organisation/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            organisationRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("organisation.title")}</Typography>
            <Stack spacing={2} direction={"row"}>
                <Button onClick={goToCreate} variant="contained" color="secondary">{t("button.create")}</Button>
                <Button onClick={goToUpdate} variant="contained" color="secondary" disabled={!selected?.id} >
                    {t("button.update")}
                </Button>
                <Button onClick={handleDelete} variant="contained" color="secondary" disabled={!selected?.id}>
                    {t("button.delete")}
                </Button>
            </Stack>
            <OverviewTable
                entities={organisationAll}
                prefix={"organisation"}
                selected={selected}
                onSelect={setSelected}
                fields={organisationOverviewFields}/>
        </Container>
    );
}

export default OrganisationOverview;
