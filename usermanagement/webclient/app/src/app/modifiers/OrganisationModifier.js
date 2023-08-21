const entityDefault = {
    name: "",
    longlongNumber: "",
    someBigDecimal: "",
    theDoulbeBugfix: "",
    id: undefined
};

const entityFields = [
    {
        name: "name",
        type: "string",
        regex: null,
        notNull: true
    },
    {
        name: "longlongNumber",
        type: "long",
        regex: null,
        notNull: false
    },
    {
        name: "someBigDecimal",
        type: "bigdecimal",
        regex: null,
        notNull: false
    },
    {
        name: "theDoulbeBugfix",
        type: "double",
        regex: null,
        notNull: false
    },
    {
        name: "address",
        type: "OneToOne",
        regex: null,
        selectList: [],
        display: [
            "city",
            "street",
            "streetNr",
            "cityCode"
        ],
        selectedIds: []
    },
];

const organisationOverviewFields = [
    {name: "name", type: "string", regex: null},
    {name: "longlongNumber", type: "long", regex: null},
    {name: "someBigDecimal", type: "bigdecimal", regex: null},
    {name: "theDoulbeBugfix", type: "double", regex: null}
];

export {
    entityDefault,
    entityFields,
    organisationOverviewFields
};
