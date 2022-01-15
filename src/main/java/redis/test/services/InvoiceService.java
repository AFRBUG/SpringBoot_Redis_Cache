package redis.test.services;
import java.util.List   ;
import redis.test.models.Invoice;

public interface InvoiceService {


    public Invoice saveInvoice(Invoice invoice) ;
    public  Invoice updateInvoice(Integer id , Invoice invoice  ) ;
    public void  deleteInvoice(Integer id) ;
    public  Invoice getOneInvoice(Integer id)  ;
    public List<Invoice> getAllInvoices()   ;

}
