SOLID Principles

The SOLID design principles encourage us to create more maintainable, understandable, and flexible software.

The five principles are as follows:

    1. Single Responsibility - a class should only have one responsbility, futhermore, it
        should only have one reason to change.
    2. Open/Closed - classes should be open for extension, but closed for modifation. In
        doing so, we stop ourselves from modifying existing code and causing potential 
        new bugs.
    3. Liskov Substitution - if class A is a subtype of class B, we should be able to replace
        B with A without disrupting the behavior of our program.
    4. Interface Segregation - larger interfaces should be split into smaller ones. By doing so
        we can ensure that implementing classes only need to be concerned about the methods that
        are of interest to them.
    5. Dependency Inversion - the principle of dependency inversion refers to the decoupling of
        software modules. This way, instead of high-level modules depending on low-level models,
        both will depend on abstractions.