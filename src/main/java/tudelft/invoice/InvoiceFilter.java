package tudelft.invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFilter {

    private final InvoiceDao invoiceDao;

    public InvoiceFilter(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public List<Invoice> filter() {

        List<Invoice> allInvoices = invoiceDao.all();

        List<Invoice> filtered = new ArrayList<>();

        for(Invoice inv : allInvoices) {
            if(inv.getValue() < 100.0)
                filtered.add(inv);
        }

        return filtered;

    }
}