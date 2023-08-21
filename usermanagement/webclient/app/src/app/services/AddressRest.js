import CrudRest from "./CrudRest";
import axios from "axios";

class AddressRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/address");
    }

    findAllWithoutOrganisation(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-organisation");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-organisation/" + selected);
        }
    }

    findAllWithoutUser(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-user");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-user/" + selected);
        }
    }
}
export default AddressRest;
