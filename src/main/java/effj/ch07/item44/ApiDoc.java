package effj.ch07.item44;

/**
 * A college degree, such as B.S., {@literal M.S.}or Ph.D.
 * College is a fountain of knowledge where many go to drink.
 */
interface ApiDoc {

    /**
     * Returns the element at the specified position in this list.
     *
     * <p>This method is <i>not</i> guaranteed to run in constant
     * time. In some implementations it may run in time proportional
     * to the element position.
     * The triangle inequality is {@literal |x + y| < |x| + |y|}.
     *
     * @param  index index of element to return; must be
     * non-negative and less than the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index >= this.size()})
     */
    Object get(int index);

}
