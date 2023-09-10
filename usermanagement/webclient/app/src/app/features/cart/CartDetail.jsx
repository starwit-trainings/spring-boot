import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import CartRest from "../../services/CartRest";
import ArticleRest from "../../services/ArticleRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/CartModifier";
import {EntityDetail, addSelectLists} from "@starwit/react-starwit";

function CartDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new CartRest(), []);
    const articleRest = useMemo(() => new ArticleRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
            articleRest.findAllWithoutCart(id)
        ];
        Promise.all(functions).then(values => {
            selectLists.push({name: "article", data: values[0].data});
            if (id) {
                entityRest.findById(id).then(response => {
                    setEntity(response.data);
                    addSelectLists(response.data, fields, setFields, selectLists);
                });
            } else {
                addSelectLists(entity, fields, setFields, selectLists);
            }
        });
    }

    return (
        <>
            <EntityDetail
                id={id}
                entity={entity}
                setEntity={setEntity}
                fields={fields}
                setFields={setFields}
                entityRest={entityRest}
                prefix="cart"
            />
        </>

    );
}

export default CartDetail;
