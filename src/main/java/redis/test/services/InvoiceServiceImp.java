package redis.test.services;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.test.models.Invoice;
import redis.test.repository.InvoiceRepository;

import java.util.*;


@Service
public class InvoiceServiceImp  implements InvoiceService   {

  private final InvoiceRepository invoiceRepository ;


    @Autowired
    InvoiceServiceImp(InvoiceRepository invoiceRepository) {
     this.invoiceRepository=invoiceRepository ;
 }


    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return  invoiceRepository.save(invoice) ;
    }

    @Override
    @CachePut(value="Invoice", key ="#invId")
    public Invoice updateInvoice(Integer id, Invoice invoice) {
       Invoice invoice1=invoiceRepository.getById(id);
        invoice1.setInvId(invoice.getInvId());
        invoice1.setInvName(invoice.getInvName());
        invoice1.setInvAmount(invoice.getInvAmount());
        return  invoiceRepository.save(invoice1);

    }

    @Override
    @CacheEvict(value = "Invoice",key = "#invid")
    public void deleteInvoice(Integer id) {
          try{
              invoiceRepository.deleteById(id);

          }catch (NullPointerException nullPointerException){
              nullPointerException.printStackTrace();
          }
    }

    @Cacheable(value = "Invoice",key = "#invid")
    @Override
    public Invoice getOneInvoice(Integer id) {
        try {
             return  invoiceRepository.getById(id);
        }catch (NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
        return  new Invoice();
    }

    @Cacheable(value = "Invoice")
    @Override
    public List<Invoice> getAllInvoices() {
        try {
            return invoiceRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
        List<Invoice>  invoices=new ArrayList<Invoice>();
        return  invoices  ;
    }





}
