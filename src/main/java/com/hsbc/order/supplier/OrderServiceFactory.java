package com.hsbc.order.supplier;

@Service
public class OrderServiceFactory {

    private final SupplierAOrderService supplierAOrderService;
    private final SupplierBOrderService supplierBOrderService;

    @Autowired
    public OrderServiceFactory(SupplierAOrderService supplierAOrderService, SupplierBOrderService supplierBOrderService) {
        this.supplierAOrderService = supplierAOrderService;
        this.supplierBOrderService = supplierBOrderService;
    }

    public SupplierOrderService getOrderService(Supplier supplier) {
        switch (supplier) {
            case SUPPLIER_A:
                return supplierAOrderService;
            case SUPPLIER_B:
                return supplierBOrderService;
            default:
                throw new UnsupportedOperationException("No order service found for supplier: " + supplier);
        }
    }
}

