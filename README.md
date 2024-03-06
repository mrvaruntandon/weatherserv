# weatherserv
This project contains a springboot applications that hosts the below api:

```shell
curl --location 'http://localhost:8080/v1/weather?postal_code=110009&country_code=in'
```

API response:
```json
{
    "current": {
        "temperature": {
            "value": 15.2,
            "unit": "°C"
        },
        "time": "2024-03-06T04:45"
    },
    "daily": {
        "min_temperature": {
            "value": 9.4,
            "unit": "°C"
        },
        "max_temperature": {
            "value": 19.9,
            "unit": "°C"
        },
        "time": "2024-03-06"
    },
    "from_cache": true
}
```

The detailed API specification is present in [api_spec.yml](/api_spec.yml).


This project integrates:
1. openstreetmap api to get latitude and longitude data from postal code
   ```shell
    curl --location 'https://nominatim.openstreetmap.org/search?postalcode=211001&country=in&format=json'
    ```
2. open-meteo api to get the weather information based on latitude and longitude
   ```shell
   curl --location 'https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m&daily=temperature_2m_max%2Ctemperature_2m_min&forecast_days=1'
   ```
3. Integrates with a redis cache instance to store results for a TTL of 30 mins

