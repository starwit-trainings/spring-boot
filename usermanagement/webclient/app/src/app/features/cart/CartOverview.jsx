import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import CartRest from "../../services/CartRest";
import {useHistory} from "react-router";
import {cartOverviewFields} from "../../modifiers/CartModifier";

function CartOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const cartRest = useMemo(() => new CartRest(), []);
    const history = useHistory();
    const [cartAll, setCartAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        cartRest.findAll().then(response => {
            setCartAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/cart/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/cart/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            cartRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("cart.title")}</Typography>
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
                entities={cartAll}
                prefix={"cart"}
                selected={selected}
                onSelect={setSelected}
                fields={cartOverviewFields}/>
        </Container>
    );
}

export default CartOverview;
