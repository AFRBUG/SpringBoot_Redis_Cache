package redis.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.test.models.Invoice;
import redis.test.services.InvoiceServiceImp;
import  java.util.List ;
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    private  final InvoiceServiceImp invoiceServiceImp ;

@Autowired
    InvoiceController(InvoiceServiceImp invoiceServiceImp){
        this.invoiceServiceImp=invoiceServiceImp;
    }

   @GetMapping("")
   public  List<Invoice> getAllInvoices(){
    return  invoiceServiceImp.getAllInvoices();
   }

   @PostMapping("")
    public  Invoice createInvoice(@RequestBody Invoice invoice){
    return  invoiceServiceImp.saveInvoice(invoice);
   }
    @PutMapping("/{id}")
    public  Invoice updateInvoice(@PathVariable Integer id ,@RequestBody Invoice invoice ){
    return  invoiceServiceImp.updateInvoice(id , invoice) ;
    }
    @DeleteMapping("/{id}")
    public void  deleteInvoice(@PathVariable Integer id) {
        invoiceServiceImp.deleteInvoice(id);

    }
}
