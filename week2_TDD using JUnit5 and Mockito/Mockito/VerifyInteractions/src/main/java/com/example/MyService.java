package com.example;

public class MyService {
	private final ExternalApi a;

    public MyService(ExternalApi a) {
        this.a = a;
    }

    public String fetchData() {
        return a.getData();
    }
}
