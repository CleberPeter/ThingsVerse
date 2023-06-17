# ThingsVerse: An Multi-Agent Systems based Simulator for IoT

ThingsVerse offers a versatile platform for modeling and simulating the behavior of things in the IoT ecosystem. Leveraging the principles of multi-agent systems, ThingsVerse enables not only simulate intercommunication among the modeled things but also their interaction with the surrounding environment.

Every thing modeled in ThingsVerse is made up of two main components: **Signals** and **Behavior**. Signals are a way of modeling communication and the exchange of information between the thing and the universe around it. The behavior, in turn, encapsulates the logic and functionality of the thing, determining how it responds to incoming signals, communicates with other things, and interacts with the environment.

In addition, ThingsVerse incorporates the modeling of intelligent computing environments with an approach based on multi-agent systems, which allows the simulation of stochastic processes with the presence of programmed agents to replicate the behaviors evidenced in dynamic and sophisticated IoT scenarios.

Finally, with ThingsVerse we hope that developers, researchers and practitioners can experiment, test and refine their IoT applications and solutions, leading to more efficient and reliable systems. Below is a breakdown of the main components of the simulator as well as a getting started.

## Signals

Things in the context of the Internet of Things can perform the most diverse functions. However, the external interactions of things can be divided into two types: interactions with other things, mapped in the ThingsVerse with **Communication Signals**, and interactions with the environment, mapped with **Enviroment Signals**.

### Communication Signals

The Communication Signals in ThingsVerse play a crucial role in the communication and interaction of things. They enable the exchange of information and coordination of actions among the modeled devices. These signals are categorized into different types, such as **Property**, **Action**, and **Event**, following the guidelines of the [Things Description (TD)](https://www.w3.org/TR/wot-thing-description/) from [Web of Things (WoT)](https://www.w3.org/WoT/) standard established by [World Wide Web Consortium (W3C)](https://www.w3.org/).

![property_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/178c9974-09ef-4c0c-bac5-98c19bd112b4) **Property:** Property signal allow things to share their state and characteristics with other things. This enables access to essential information and monitoring of important variables in the IoT environment.

![action_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/3c85885d-e402-4ecc-92d1-4bc2426ee231) **Action:** Action signal enable things to perform specific actions. These actions can range from simple operations to more complex tasks. With Action signals, things can interact with each other, carrying out coordinated actions to achieve a common goal.

![event_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/94d96a7f-31bf-4fe3-9cf7-da011ae0ebf7) **Event:** Event signals notify relevant events that occur in the IoT environment. They allow things to inform about state changes, occurrence of specific events, or other important information for the system's operation.

### Enviroment Signals

Environment signals are not foreseen in the WoT standard, however they are used by ThingsVerse as a way for modeled things to interact with the environment. 

![actuator_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/01b77e0c-83c8-414c-95f6-b3560000dc21) **Actuator:** Actuator signals empower things to take actions that affect the simulated environment. For example, controlling external devices, triggering mechanisms, or making changes in the environment, according to the received instructions and needs.

![sensing_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/cfc3750c-4ab3-4f24-9182-b88e85b3dba9) **Sensing:** Sensing signals enable things to gather information about the environment they are embedded in. This can include measuring parameters such as temperature, humidity, luminosity, and other relevant data for the IoT context.

The Figure 1 exemplifies the definition of the signals.

![Screenshot from 2023-06-16 21-49-45](https://github.com/CleberPeter/ThingsVerse/assets/30049450/485c6fb5-a2c4-4e82-8721-bba7212b0191)
|:--:|
| *Figure 1 - Example of Signals Mapping* |

## Behavior

The behavior of the thing is defined through a Python script. It specifies how the thing processes Signals, such as Property updates, Action requests, or send Event notifications, and how it generates appropriate responses or triggers actions based on these signals.

The behavior enables the thing to exhibit intelligent and autonomous behavior, allowing it to adapt to changes in its environment, collaborate with other things, and perform complex tasks. It embodies the intelligence and decision-making capabilities of the thing, enabling it to make informed choices and take appropriate actions based on its internal state, external inputs, and predefined rules.


