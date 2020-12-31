# Basic JAX-RS API Project

It's basic rest-api project based on JAX-RS library combined with Eclipse Dynamic Web Project

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

```
Java JDK 11
Eclipse
Apache Tomcat 9+
```

## Built With

* [JAX-RS](https://eclipse-ee4j.github.io/jersey.github.io/download.html) - JAX-RS 2.30.1  [library](https://repo1.maven.org/maven2/org/glassfish/jersey/bundles/jaxrs-ri/2.30.1/jaxrs-ri-2.30.1.zip)


## Gateway EndPoint

* **00. Context Root**

```
http://{IP}:{PORT}/jrsapp/
```

* **01. App Service**

```
http://{IP}:{PORT}/jrsapp/AppService
```

* **02. Desktop Service**

```
http://{IP}:{PORT}/jrsapp/DesktopService
```

* **03. Web Service**

```
http://{IP}:{PORT}/jrsapp/WebService
```

* **04. Preference Reload Service**

```
http://{IP}:{PORT}/jrsapp/ReloadService
```

## Basic RestAPI Request/Response

#### Request

```json
{
    "request":{
        "serviceId":"1",
        "firstName": "First Name",
        "lastName": "Last Name",
        "fatherName":"Father Name",
        "motherName":"Mother Name",
        "spouseName":"Spouse Name",
        "dob":"31/12/1800",
        "mobileNumber":"8801912345678",
        "presentAddress":{
            "villageOrHouseOrRoad":"House and Road",
            "postcode":"10000",
            "district":"Dhaka",
            "countryCode":"BD",
            "country":"Bangladesh"
        },
        "parmanentAddress":{
            "villageOrHouseOrRoad":"Village",
            "postcode":"30000",
            "district":"Cumilla",
            "countryCode":"BD",
            "country":"Bangladesh"
        }
    }
}
```

#### Response
```json
{
    "channelId": 1,
    "responseId": "dcf6db16-272e-4624-9b90-1fe97e71486e",
    "responseCode": 0,
    "responseMsg": "Welcome AppService",
    "response": {
        "request": {
       	   "serviceId": "1",
            "firstName": "First Name",
            "lastName": "Last Name",
            "fatherName": "Father Name",
            "motherName": "Mother Name",
            "spouseName": "Spouse Name",
            "dob": "31/12/1800",
            "mobileNumber": "8801912345678",    
            "parmanentAddress": {
                "country": "Bangladesh",
                "villageOrHouseOrRoad": "Village",
                "countryCode": "BD",
                "district": "Cumilla",
                "postcode": "30000"
            },
            "presentAddress": {
                "country": "Bangladesh",
                "villageOrHouseOrRoad": "House and Road",
                "countryCode": "BD",
                "district": "Dhaka",
                "postcode": "10000"
            }
        }
    }
}
```

#### Channel Definition

```java
public enum Channel {
	App(1), Web(2), Desktop(3);

	int value;

	Channel(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
```
#### Service Definition

```java
public enum Service {
	PROFILE_SAVE(1), PROFILE_INFO(2), PROFIILE_UPDATE(3),PROFILE_DELETE(4);

	int value;

	Service(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}
}
```

#### Service Response Code

```java
public enum ResponseCode {

	SUCCESS(0), FAILED(1), TIMEOUT(-1), PENDING(2), UNKNOWN(-2);

	int value;

	ResponseCode(int v) {
		this.value = v;
	}

	public int getValue() {
		return value;
	}

}
```

## Versioning

We use `@Git` for @versioning.

## Authors

* **Biswajit Debnath** - *Initial work*

## Developments

* Biswajit Debnath

## License

This project is licensed under the `@CoderBD`


