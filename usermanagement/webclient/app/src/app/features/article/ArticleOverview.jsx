import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import ArticleRest from "../../services/ArticleRest";
import {useHistory} from "react-router";
import {articleOverviewFields} from "../../modifiers/ArticleModifier";

function ArticleOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const articleRest = useMemo(() => new ArticleRest(), []);
    const history = useHistory();
    const [articleAll, setArticleAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        articleRest.findAll().then(response => {
            setArticleAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/article/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/article/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            articleRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("article.title")}</Typography>
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
                entities={articleAll}
                prefix={"article"}
                selected={selected}
                onSelect={setSelected}
                fields={articleOverviewFields}/>
        </Container>
    );
}

export default ArticleOverview;
