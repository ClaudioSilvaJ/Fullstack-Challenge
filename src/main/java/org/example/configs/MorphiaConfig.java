package org.example.configs;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

public class MorphiaConfig {
    final Datastore datastore;

    public MorphiaConfig(String databaseName, int databasePort) {
        MongoClient mongoClient = new MongoClient("localhost", databasePort);
        Morphia morphia = new Morphia();
        morphia.mapPackage("org.example.classes");
        datastore = morphia.createDatastore(mongoClient, databaseName);
        datastore.ensureIndexes();
    }

    public Datastore getDatastore() {
        return datastore;
    }
}

