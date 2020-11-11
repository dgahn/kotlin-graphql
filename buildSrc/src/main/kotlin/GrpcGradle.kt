object GrpcPlugin {
    const val protobuf = "com.google.protobuf"
    const val grpc = "grpc"
    const val grpcKt = "grpcKt"
}

object GrpcVersion {
    const val protobuf = "0.8.13"
    const val protoc = "3.13.0"
    const val grpcKotlin = "0.2.1"
    const val grpc = "1.33.1"
}

object GrpcLibs {
    const val protobufJava = "com.google.protobuf:protobuf-java:${GrpcVersion.protoc}"
    const val protobufJavaUtil = "com.google.protobuf:protobuf-java-util:${GrpcVersion.protoc}"
    const val grpcKotlinStub = "io.grpc:grpc-kotlin-stub:${GrpcVersion.grpcKotlin}"
    const val grpcStub = "io.grpc:grpc-stub:${GrpcVersion.grpc}"
    const val grpcProtobuf = "io.grpc:grpc-protobuf:${GrpcVersion.grpc}"
    const val grpcNettyShaded = "io.grpc:grpc-netty-shaded:${GrpcVersion.grpc}"
}

object GrpcArtifact {
    const val protoc = "com.google.protobuf:protoc:${GrpcVersion.protoc}"

}