package Assignment8;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

import java.net.UnknownHostException;

public class RiakTask {

    // This will create a client object that we can use to interact with Riak
    private static RiakCluster setUpCluster() throws UnknownHostException {
        // This example will use only one node listening on localhost:10017
        RiakNode node = new RiakNode.Builder()
                .withRemoteAddress("127.0.0.1")
                .withRemotePort(8087)
                .build();

        // This cluster object takes our one node as an argument
        RiakCluster cluster = new RiakCluster.Builder(node)
                .build();

        // The cluster must be started to work, otherwise you will see errors
        cluster.start();

        return cluster;
    }

    public static void main(String[] args) {

        String bucketName = "s22556";

        try {
            RiakCluster cluster = setUpCluster();
            RiakClient client = new RiakClient(cluster);

            System.out.println("1. Creating a document...");
            RiakObject quoteObject = new RiakObject()
                    .setContentType("text/plain")
                    .setValue(BinaryValue.create("simple document"));

            Namespace quotesBucket = new Namespace(bucketName);
            Location quoteObjectLocation = new Location(quotesBucket, "Task8");
            StoreValue storeOp = new StoreValue.Builder(quoteObject)
                    .withLocation(quoteObjectLocation)
                    .build();

            StoreValue.Response response = client.execute(storeOp);

            System.out.println("2. Fetching the document...");
            FetchValue fetchOp = new FetchValue.Builder(quoteObjectLocation)
                    .build();
            RiakObject fetchedObject = client.execute(fetchOp).getValue(RiakObject.class);
            System.out.println("3. Printing the value of the document...");
            System.out.println(fetchedObject.getValue());

            System.out.println("4. Updating the document...");
            fetchedObject.setValue(BinaryValue.create("simple document updated"));
            StoreValue updateOp = new StoreValue.Builder(fetchedObject)
                    .withLocation(quoteObjectLocation)
                    .build();
            StoreValue.Response updateOpResp = client.execute(updateOp);

            System.out.println("5. Fetching the updated document...");
            FetchValue updateFetchOp = new FetchValue.Builder(quoteObjectLocation)
                    .build();
            RiakObject fetchedUpdatedObject = client.execute(updateFetchOp).getValue(RiakObject.class);
            System.out.println("6. Printing hte value of updated document...");
            System.out.println(fetchedUpdatedObject.getValue());

            System.out.println("7. Deleting the document...");
            DeleteValue deleteOp = new DeleteValue.Builder(quoteObjectLocation)
                    .build();
            client.execute(deleteOp);

            System.out.println("8. Fetching the deleted document...");
            FetchValue deletedFetchOp = new FetchValue.Builder(quoteObjectLocation)
                    .build();
            RiakObject fetchedDeletedObject = client.execute(deletedFetchOp).getValue(RiakObject.class);

            System.out.println("9. Printing the value of deleted document...");
            System.out.println(fetchedDeletedObject);

            cluster.shutdown();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
