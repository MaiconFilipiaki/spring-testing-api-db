package br.com.mdfilipiaki.springwithjunit.grpc;

import br.com.mdfilipiaki.springwithjunit.EmptyRequest;
import br.com.mdfilipiaki.springwithjunit.ProductResponse;
import br.com.mdfilipiaki.springwithjunit.ProductServiceRpcGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductResource extends ProductServiceRpcGrpc.ProductServiceRpcImplBase {

    @Override
    public void getProduct(EmptyRequest request, StreamObserver<ProductResponse> responseObserver) {
        var response = ProductResponse.newBuilder()
                .setName("TESTE")
                .setPrice(100.0F)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
