# ThingsVerse: An Multi-Agent Systems based Simulator for IoT

ThingsVerse offers a versatile platform for modeling and simulating the behavior of things in the IoT ecosystem. Leveraging the principles of multi-agent systems, ThingsVerse enables not only simulate intercommunication among the modeled things but also their interaction with the surrounding environment.

Every thing modeled in ThingsVerse is made up of two main components: **Signals** and **Behavior**. Signals are a way of modeling communication and the exchange of information between the thing and the universe around it. The behavior, in turn, encapsulates the logic and functionality of the thing, determining how it responds to incoming signals, communicates with other things, and interacts with the environment.

In addition, ThingsVerse incorporates the modeling of intelligent computing environments with an approach based on multi-agent systems, which allows the simulation of stochastic processes with the presence of programmed agents to replicate the behaviors evidenced in dynamic and sophisticated IoT scenarios.

Finally, with ThingsVerse we hope that developers, researchers and practitioners can experiment, test and refine their IoT applications and solutions, leading to more efficient and reliable systems. Below is a breakdown of the main components of the simulator as well as a getting started.

## Signals

Things in the context of the Internet of Things can perform the most diverse functions. However, the external interactions of things can be divided into two types: interactions with other things, mapped in the ThingsVerse with **Communication Signals**, and interactions with the environment, mapped with **Enviroment Signals**.

### Communication Signals

The Communication Signals in ThingsVerse play a crucial role in the communication and interaction of things. They enable the exchange of information and coordination of actions among the modeled devices. These signals are categorized into different types, such as **Property**, **Action**, and **Event**, following the guidelines of the [Things Description (TD)](https://www.w3.org/TR/wot-thing-description/) from [Web of Things (WoT)](https://www.w3.org/WoT/) standard established by [World Wide Web Consortium (W3C)](https://www.w3.org/).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![property_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/178c9974-09ef-4c0c-bac5-98c19bd112b4) **Property:** Property signal allow things to share their state and characteristics with other things. This enables access to essential information and monitoring of important variables in the IoT environment.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![action_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/3c85885d-e402-4ecc-92d1-4bc2426ee231) **Action:** Action signal enable things to perform specific actions. These actions can range from simple operations to more complex tasks. With Action signals, things can interact with each other, carrying out coordinated actions to achieve a common goal.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![event_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/94d96a7f-31bf-4fe3-9cf7-da011ae0ebf7) **Event:** Event signals notify relevant events that occur in the IoT environment. They allow things to inform about state changes, occurrence of specific events, or other important information for the system's operation.

### Enviroment Signals

Environment signals are not foreseen in the WoT standard, however they are used by ThingsVerse as a way for modeled things to interact with the environment. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![actuator_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/01b77e0c-83c8-414c-95f6-b3560000dc21) **Actuator:** Actuator signals empower things to take actions that affect the simulated environment. For example, controlling external devices, triggering mechanisms, or making changes in the environment, according to the received instructions and needs.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![sensing_connection_panel](https://github.com/CleberPeter/ThingsVerse/assets/30049450/cfc3750c-4ab3-4f24-9182-b88e85b3dba9) **Sensing:** Sensing signals enable things to gather information about the environment they are embedded in. This can include measuring parameters such as temperature, humidity, luminosity, and other relevant data for the IoT context.

## Things

The things modeled in ThingsVerse are nothing more than a block with a set of signals with a linked behavior. The Figure 1 exemplifies the definition of Smart Air Condittioner. 

| ![Screenshot from 2023-06-16 21-49-45](https://github.com/CleberPeter/ThingsVerse/assets/30049450/4f8346f3-854b-4c30-9b3a-d0708518a41c) |
|:--:|
| *Figure 1 - Smart Air Condittioner Thing* |

The Smart Air Condittioner modeled has two properties: *powerConsuption* so that the energy consumption of the thing can be read and the *temperature* so that it can be read and assigned the desired temperature. In addition, it has a *do-OnOff* action that allows you to change the operating state of the thing and an event called *on-temperatureReached* that notifies you when the target temperature has been reached. 

To monitor and control the environment the thing has two Environment Signals, *air* and *temperature*. The *air* signal, as can be seen in the figure, is an actuator and therefore, based on the other signals, it defines the intensity and temperature of the air exhaled by the air conditioner. The *temperature* sensing signal, in turn, aims to measure the current temperature of the environment.

## Agents

Agents are mobile elements with stochastic behavior that interact with things and the environment. The agents do not have any previously defined signal, after all their interactions are dynamically established according to their position and programmed behavior. The Figure 2 shows the model of an person called Bob which can move and interact with things and the simulated environment.

| ![Screenshot from 2023-06-17 22-20-40](https://github.com/CleberPeter/ThingsVerse/assets/30049450/dc90ae40-9c94-4488-89c8-aa55b376561f) |
|:--:|
| *Figure 2 - Person Agent* |

It should be noted that despite not having previously defined signals, agents can interact with any signal present in the simulation, as long as this is foreseen in their behavior.

## Enviroment Components

In ThingsVerse, some things are modeled with the specific objective of representing the simulation environment and its specificities, that is, they are things that only have signals from the environment, sensing and actuators. In this context, for these things the following nomenclature is derived.

### Variables

Variables, as the name implies, represent some physical quantity over which there is interest on the part of the thing to monitor and/or control it. The Figure 3 shows the temperature variable modeling.

| ![Screenshot from 2023-06-17 00-11-04](https://github.com/CleberPeter/ThingsVerse/assets/30049450/993fd523-1588-479e-879f-35d47252eadb) |
|:--:|
| *Figure 3 - Temperature Variable* |

This thing has only one Sensing Signal *dT/dt* to monitor a update rate of temperature and one Actuator Signal *temperature* to provide information of temperature from the environment. 

### Adapters

Sometimes information and magnitudes need to be converted and adapted to enable monitoring and control. In this sense, we include adapters whose purpose is to merge multiple signals to convert them into the desired information. The Figure 4 shows the air to temperature adapter model.

| ![Screenshot from 2023-06-17 00-19-00](https://github.com/CleberPeter/ThingsVerse/assets/30049450/863eb892-f0a1-442a-8494-a70e3a656db2) |
|:--:|
| *Figure 4 - Air to Temperature Adapter* |

This adapter has 3 sensing signals that are merged to produce an actuator signal. In short, information about the air supplied by the air conditioner and the current room temperature and volume is used to determine the resulting temperature variation in the room.

### Objects

The objects model physical elements in the virtual environment and are intended to enable the simulation of the behavior of the intelligent environment in the presence of them. Figure 5 shows the model of a door whose only function is to perform a translation in the y direction, based on its Sensing signal.

| ![Screenshot from 2023-06-18 00-08-00](https://github.com/CleberPeter/ThingsVerse/assets/30049450/93f56637-183c-462a-96ba-36e2054ec1a1) |
|:--:|
| *Figure 5 - Door Object* |

The movement of the door results in the obstruction or clearing of the movement of the agents and therefore allows simulating situations of access control and containment of these.

## Context

Context is the environment in which a given set of elements is contained. The context has its own things, variables and objects. Figure 6 shows the context of a room with an intelligent climate control system.

![Screenshot from 2023-06-18 00-01-54](https://github.com/CleberPeter/ThingsVerse/assets/30049450/a6c5e689-dcc7-40f7-8796-218252343bfe)
|:--:|
| *Figure 6 - Intelligent Climate Control System Context* |

In this context, it is possible to verify that the agent first requests entry into the context by executing a DoorControler action that produces an action on the Door object, the translation of this object in the y direction and then clearing the agent's entrance.

However, opening the door also results in instantaneous room volume variation that directly impacts the room temperature. A variation in the temperature of the room is detected with the monitoring carried out by the air conditioning thing that regulates the amount and temperature of the air to re-establish the target temperature.

Upon entering the room, the agent can also measure the temperature and, based on its behavior, change the air conditioning temperature property to another value.

## Behavior

The behavior of the thing is defined through a Python script. It specifies how the thing processes Signals, such as Property updates, Action requests, or send Event notifications, and how it generates appropriate responses or triggers actions based on these signals.

The behavior enables the thing to exhibit intelligent and autonomous behavior, allowing it to adapt to changes in its environment, collaborate with other things, and perform complex tasks. It embodies the intelligence and decision-making capabilities of the thing, enabling it to make informed choices and take appropriate actions based on its internal state, external inputs, and predefined rules.
