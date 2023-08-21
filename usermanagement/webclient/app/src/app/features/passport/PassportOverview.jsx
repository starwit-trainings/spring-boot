import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import PassportRest from "../../services/PassportRest";
import {useHistory} from "react-router";
import {passportOverviewFields} from "../../modifiers/PassportModifier";

function PassportOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const passportRest = useMemo(() => new PassportRest(), []);
    const history = useHistory();
    const [passportAll, setPassportAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        passportRest.findAll().then(response => {
            setPassportAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/passport/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/passport/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            passportRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("passport.title")}</Typography>
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
                entities={passportAll}
                prefix={"passport"}
                selected={selected}
                onSelect={setSelected}
                fields={passportOverviewFields}/>
        </Container>
    );
}

export default PassportOverview;
