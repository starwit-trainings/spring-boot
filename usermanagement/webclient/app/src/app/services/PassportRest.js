import CrudRest from "./CrudRest";
import axios from "axios";

class PassportRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/passport");
    }

    findAllWithoutUser(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-user");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-user/" + selected);
        }
    }
}
export default PassportRest;
