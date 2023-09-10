const entityDefault = {
    name: "",
    color: "",
    price: "",
    weight: "",
    id: undefined
};

const entityFields = [
    {
        name: "name",
        type: "string",
        regex: null,
        notNull: false
    },
    {
        name: "color",
        type: "string",
        regex: null,
        notNull: false
    },
    {
        name: "price",
        type: "double",
        regex: null,
        notNull: false
    },
    {
        name: "weight",
        type: "double",
        regex: null,
        notNull: false
    },
];

const articleOverviewFields = [
    {name: "name", type: "string", regex: null},
    {name: "color", type: "string", regex: null},
    {name: "price", type: "double", regex: null},
    {name: "weight", type: "double", regex: null}
];

export {
    entityDefault,
    entityFields,
    articleOverviewFields
};
