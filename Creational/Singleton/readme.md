# Singleton

  A singleton is a creational pattern, which describes a way to
  create an object. It is a powerful technique, but it is also one of
  the simplest examples of a design pattern.
  
  A singleton design pattern only has one object of a class. This
  might be desirable in order to circumvent conflicts or
  inconsistencies, by keeping clear which object the program
  should draw from. For example, the preferences of an app, the
  print queue of your printer, or the software driver for a device
  are all objects where it is preferable to only have one. If there
  are multiple instances, it can be confusing for the program
  output.
  
  Another goal of the singleton design pattern is that the single
  object is globally accessible within the program.
  
  In order to implement a singleton design pattern, the best
  practice is to build the “one and only one” goal into the class
  itself so that creating another instance of a Singleton class is
  not even possible. This “codifies” the design intent within the
  software. This is necessary if working on a large project or on
  projects with multiple develop
