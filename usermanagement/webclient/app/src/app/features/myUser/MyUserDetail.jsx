import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import MyUserRest from "../../services/MyUserRest";
import AddressRest from "../../services/AddressRest";
import OrganisationRest from "../../services/OrganisationRest";
import PassportRest from "../../services/PassportRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/MyUserModifier";
import {EntityDetail, addSelectLists} from "@starwit/react-starwit";

function MyUserDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new MyUserRest(), []);
    const addressRest = useMemo(() => new AddressRest(), []);
    const organisationRest = useMemo(() => new OrganisationRest(), []);
    const passportRest = useMemo(() => new PassportRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
            addressRest.findAllWithoutUser(id),
            organisationRest.findAll(),
            passportRest.findAllWithoutUser(id)
        ];
        Promise.all(functions).then(values => {
            selectLists.push({name: "address", data: values[0].data});
            selectLists.push({name: "organisation", data: values[1].data});
            selectLists.push({name: "passport", data: values[2].data});
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
                prefix="myUser"
            />
        </>

    );
}

export default MyUserDetail;
