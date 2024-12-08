FROM gradle:8.11
WORKDIR /usr/src/sepp-prototype
COPY . .
RUN gradle installDist

FROM gradle:jdk21
WORKDIR /root/
COPY --from=0 /usr/src/sepp-prototype/build/install/sepp-prototype .
CMD ["./bin/sepp-prototype"]

