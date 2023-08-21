import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import MyUserRest from "../../services/MyUserRest";
import {useHistory} from "react-router";
import {myUserOverviewFields} from "../../modifiers/MyUserModifier";

function MyUserOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const myuserRest = useMemo(() => new MyUserRest(), []);
    const history = useHistory();
    const [myUserAll, setMyUserAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        myuserRest.findAll().then(response => {
            setMyUserAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/myuser/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/myuser/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            myuserRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("myUser.title")}</Typography>
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
                entities={myUserAll}
                prefix={"myUser"}
                selected={selected}
                onSelect={setSelected}
                fields={myUserOverviewFields}/>
        </Container>
    );
}

export default MyUserOverview;
