const entityDefault = {
    passportId: "",
    dateCreated: null,
    someTime: null,
    logTime: null,
    id: undefined
};

const entityFields = [
    {
        name: "passportId",
        type: "integer",
        regex: null,
        notNull: true
    },
    {
        name: "dateCreated",
        type: "date",
        regex: null,
        notNull: false
    },
    {
        name: "someTime",
        type: "time",
        regex: null,
        notNull: false
    },
    {
        name: "logTime",
        type: "timestamp",
        regex: null,
        notNull: false
    },
];

const passportOverviewFields = [
    {name: "passportId", type: "integer", regex: null},
    {name: "dateCreated", type: "date", regex: null},
    {name: "someTime", type: "time", regex: null},
    {name: "logTime", type: "timestamp", regex: null}
];

export {
    entityDefault,
    entityFields,
    passportOverviewFields
};
