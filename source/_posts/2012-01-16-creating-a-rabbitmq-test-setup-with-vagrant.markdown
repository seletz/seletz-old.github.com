---
layout: post
title: "Creating a RabbitMQ test setup with vagrant"
date: 2012-01-18 16:00
comments: true
published: yes
categories: tools testing rabbitmq
---

In this post I'll provide a writeup on how I created a test setup for
a project I'm working on.  The project uses [RabbitMQ] [1] to distribute
tasks to a worker, and the production system is a cluster of Apache/Tomcat
machines.

I'll use [vagrant] [2] to create two test machines, one which runs [RabbitMQ] [1], the other
one will run the actual worker code.

<!-- more -->

Preparation
-----------

I'll have the [vagrant] [2] files in a subdirectory `vagrant` in my git repository.  I'll
add the `Vagrantfile` and all provisioning scriptzs there::

    $ mkdir vagrant

The `Vagrantfile` looks like this::

{% include_code vagrant file ruby/Vagrantfile-rabbitmq lang:ruby %}

The configuration sets the machines up, such that:

- both have a IP to talk to eachother
- on the rabbitmq machine I've used the shell provisioner to install
  [RabbitMQ] [1] 2.7.1
- on the worker machine I've used the shell provisioner to create a python
  development environment in /opt
- share my source folder on the worker

Note: For some reason I wanted to have all the [vagrant] [2] stuff in a separate directory.  I
**could** have put the Vagrantfile in the top-level directory and thus saved me the additional
shared folder.  Oh well.

Here are the provisioning shell scripts::

{% include_code rabbitmq.sh shell/vagrant-rabbitmq.sh lang:bash %}

{% include_code worker.sh shell/vagrant-worker.sh lang:bash %}

Usage
-----

To use the system I now just need to do a::

    $ vagrant up

And I'm set.


[1]: http://www.rabbitmq.com/ 		"RabbitMQ"
[2]: http://vagrantup.com/ 		"vagrant"
[3]: https://www.virtualbox.org/	"VirtualBox"

