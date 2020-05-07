# Description
This module is a data processing application which support sending alert over SMTP protocol.

# Prerequisite
Kapacitor version v1.5

# Install
MacOS:
  ```
  brew update
  brew install kapacitor
  ```
Ubuntu:
  ```
  wget https://dl.influxdata.com/kapacitor/releases/kapacitor_1.5.5-1_amd64.deb
  sudo dpkg -i kapacitor_1.5.5-1_amd64.deb
  ```

# Configuration
Replace default configuration file by kapacitor.conf in this project.
Using command below to see current configuration path:
  ```
  kapacitord
  ```
By default:
MacOS: /usr/local/etc/kapacitor.conf
Ubuntu: /etc/kapacitor/kapacitor.conf

# Start Service
MacOS:
  ```
  kapacitord -config /usr/local/etc/kapacitor.conf
  ```
Ubuntu:
  ```
  sudo systemctl start kapacitor
  ```

# Run
Set up event handler:
  ```
  kapacitor define cpu_alert -tick cpu_alert.tick
  kapacitor enable cpu_alert

  ```
Show information:
  ```
  kapacitor show cpu_alert
  ```