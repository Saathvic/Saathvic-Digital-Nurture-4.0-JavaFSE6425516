package com.example;

public class MyService {
	private final ExternalAPI a;

    public MyService(ExternalAPI a) {
        this.a = a;
    }

    public String fetchData() {
        return a.getData();
    }
}
