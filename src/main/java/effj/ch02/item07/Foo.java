package effj.ch02.item07;

/**
 Finalizer Guardian idiom
 <p>
 If a subclass implementor overrides a superclass finalizer but forgets to invoke it,
 the superclass finalizer will never be invoked. It is possible to defend against
 such a careless or malicious subclass at the cost of creating an additional object
 for every object to be finalized.
 <p>
 Instead of putting the finalizer on the class requiring finalization,
 put the finalizer on an anonymous class (Item 22) whose sole purpose is to finalize its enclosing instance.
 A single instance of the anonymous class, called a finalizer guardian,
 is created for each instance of the enclosing class.
 <p>
 The enclosing instance stores the sole reference to its finalizer guardian
 in a private instance field so the finalizer guardian becomes eligible for finalization
 at the same time as the enclosing instance. When the guardian is finalized,
 it performs the finalization activity desired for the enclosing instance,
 just as if its finalizer were a method on the enclosing class:
 */
public class Foo {

    // Sole purpose of this object is to finalize outer Foo object
    private final Object finalizerGuardian = new Object() {
        @Override protected void finalize() throws Throwable {
            //... // Finalize outer Foo object
            // тут скорее надо писать логику по очистке ресурсов
            // для внешнего класса, т.к. всё равно из какого места будет вызвана очистка.
            // в данном случае из файналайзера внутреннего объекта
        }
    };

    //... // Remainder omitted
}