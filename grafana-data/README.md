# Description
This module is a visualization application which allows querying, visualizing, alerting on metrics stored in InfluxDB

# Prerequisite
Grafana version v6.7.3

# Install
```
1. Install and run Grafana service.
2. Add dashboard to your local Grafana
	- Create - Import Dashboard - Upload .json files.
```

Note
```
There are two difference Dashboards. 
- The Main-Dashboard is to contain host data included OK and Error host services.
- The Error-Host is to containt error data which is only be visualized when host error started.
```

PC Names
```
Normal PC: PC-1, PC-2, PC-3, PC-4, PC-5
Error PC: PC-Error
```
