const entityDefault = {
    firstName: "",
    lastName: "",
    gender: "",
    isRich: "",
    title: "",
    id: undefined
};

const entityFields = [
    {
        name: "firstName",
        type: "string",
        regex: null,
        notNull: true
    },
    {
        name: "lastName",
        type: "string",
        regex: null,
        notNull: true
    },
    {
        name: "gender",
        type: "enum",
        regex: null,
        notNull: false,
        enumName: "gender",
        selectList: [
            "female",
            "male"
        ]
    },
    {
        name: "isRich",
        type: "boolean",
        regex: null,
        notNull: false
    },
    {
        name: "title",
        type: "string",
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
    {
        name: "organisation",
        type: "ManyToMany",
        regex: null,
        selectList: [],
        display: [
            "name",
            "longlongNumber",
            "someBigDecimal",
            "theDoulbeBugfix"
        ],
        selectedIds: []
    },
    {
        name: "passport",
        type: "OneToMany",
        regex: null,
        selectList: [],
        display: [
            "passportId",
            "dateCreated",
            "someTime",
            "logTime"
        ],
        selectedIds: []
    }
];

const myUserOverviewFields = [
    {name: "firstName", type: "string", regex: null},
    {name: "lastName", type: "string", regex: null},
    {name: "gender", type: "enum", regex: null},
    {name: "isRich", type: "boolean", regex: null},
    {name: "title", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    myUserOverviewFields
};
