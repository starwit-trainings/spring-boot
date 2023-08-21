import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import PassportRest from "../../services/PassportRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/PassportModifier";
import {EntityDetail, addSelectLists} from "@starwit/react-starwit";

function PassportDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new PassportRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
        ];
        Promise.all(functions).then(values => {
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
                prefix="passport"
            />
        </>

    );
}

export default PassportDetail;
