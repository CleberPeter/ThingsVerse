# ThingsVerse: An Multi-Agent Systems based Simulator for IoT

ThingsVerse offers a versatile platform for modeling and simulating the behavior of things in the IoT ecosystem. Leveraging the principles of multi-agent systems, ThingsVerse enables not only intercommunication among the modeled things but also their interaction with the surrounding environment.

By adhering to the [Web of Things](https://www.w3.org/WoT/) standard established by the World Wide Web Consortium (W3C), ThingsVerse provides a robust framework for things to communicate and exchange information with one another. This collaborative network of interconnected devices fosters seamless interoperability and enables the simulation of sophisticated IoT scenarious.

Additionally, ThingsVerse incorporates a simulation environment and adopts a multi-agent systems-based approach. This combination allows for a realistic and dynamic representation of the IoT ecosystem. Developers, researchers, and practitioners can leverage this simulation capability to experiment, test, and refine their IoT applications and solutions, leading to more efficient and reliable systems.

## Signals

Things in the context of the Internet of Things can perform the most diverse functions. However, the interactions of things can be divided into two types: interactions with other things, mapped in the ThingsVerse with **Communication Signals**, and interactions with the environment, mapped with **Enviroment Signals**.

### Communication Signals

The Communication Signals in ThingsVerse play a crucial role in the communication and interaction of things. They enable the exchange of information and coordination of actions among the modeled devices. These signals are categorized into different types, such as **Property**, **Action**, and **Event**, following the guidelines of the [Things Description (TD)](https://www.w3.org/TR/wot-thing-description/) from WoT standard.

* **Property:** this signal allow things to share their state and characteristics with other things. This enables access to essential information and monitoring of important variables in the IoT environment.
* **Action:** this signal enable things to perform specific actions. These actions can range from simple operations to more complex tasks. With Action signals, things can interact with each other, carrying out coordinated actions to achieve a common goal.
* **Event:** Event signals notify relevant events that occur in the IoT environment. They allow things to inform about state changes, occurrence of specific events, or other important information for the system's operation.

### Enviroment Signals

Environment signals are not foreseen in the WoT pattern, however they are used by ThingsVerse as a way for modeled things to interact with the environment. 

* **Actuator:** Actuator signals empower things to take actions that affect the simulated environment. For example, controlling external devices, triggering mechanisms, or making changes in the environment, according to the received instructions and needs.

* **Sensing:** Sensing signals enable things to gather information about the environment they are embedded in. This can include measuring parameters such as temperature, humidity, luminosity, and other relevant data for the IoT context.

![Screenshot from 2023-06-16 11-22-40](https://github.com/CleberPeter/ThingsVerse/assets/30049450/3eec709d-5002-43b7-9525-1ccbe851c570)

## Behavior

#todo
