const entityDefault = {
    created: null,
    id: undefined
};

const entityFields = [
    {
        name: "created",
        type: "timestamp",
        regex: null,
        notNull: false
    },
    {
        name: "article",
        type: "OneToMany",
        regex: null,
        selectList: [],
        display: [
            "name",
            "color",
            "price",
            "weight"
        ],
        selectedIds: []
    }
];

const cartOverviewFields = [
    {name: "created", type: "timestamp", regex: null}
];

export {
    entityDefault,
    entityFields,
    cartOverviewFields
};
