package io;

import fit.Fixture;
import io.repository.ProductRepositoryImpl;
import io.repository.RentListRepositoryImpl;
import io.repository.UserRepositoryImpl;

public class SetUp extends Fixture {

    static RentApp app;

    public SetUp() {
        ProductRepositoryImpl.INSTANCE.deleteAll();
        UserRepositoryImpl.INSTANCE.deleteAll();
        RentListRepositoryImpl.INSTANCE.deleteAll();
        app = new RentApp(
                ProductRepositoryImpl.INSTANCE,
                UserRepositoryImpl.INSTANCE,
                RentListRepositoryImpl.INSTANCE
        );
    }

}
