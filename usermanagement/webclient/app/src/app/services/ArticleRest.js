import CrudRest from "./CrudRest";
import axios from "axios";

class ArticleRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/article");
    }

    findAllWithoutCart(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-cart");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-cart/" + selected);
        }
    }
}
export default ArticleRest;
