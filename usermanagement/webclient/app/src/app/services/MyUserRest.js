import CrudRest from "./CrudRest";
import axios from "axios";

class MyUserRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/myuser");
    }

    findAllWithoutAddress(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-address");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-address/" + selected);
        }
    }
}
export default MyUserRest;
