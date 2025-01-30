function fun1() {
    
    let form1 = document.forms[0];
    clearPreviousInput(form1);

 
    let buyerAddress = document.createElement("input");
    buyerAddress.type = "text";
    buyerAddress.name = "buyeraddress";
    buyerAddress.placeholder = "Enter your address";

    
    let submitButton = form1.querySelector('input[type="submit"]');
    form1.insertBefore(buyerAddress, submitButton);
}

function fun2() {
   
    let form1 = document.forms[0];
    clearPreviousInput(form1);

    
    let sellerBusiness = document.createElement("input");
    sellerBusiness.type = "text";
    sellerBusiness.name = "businessname";
    sellerBusiness.placeholder = "Enter your business name";

   
    let submitButton = form1.querySelector('input[type="submit"]');
    form1.insertBefore(sellerBusiness, submitButton);
}



function clearPreviousInput(form) {
    let inputs = form.querySelectorAll('input[name="buyeraddress"], input[name="businessname"]');
    inputs.forEach(input => input.remove());
}
