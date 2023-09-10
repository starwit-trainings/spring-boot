import CrudRest from "./CrudRest";

class CartRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/cart");
    }
}
export default CartRest;
