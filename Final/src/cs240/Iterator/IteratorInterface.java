package cs240.Iterator;

public interface IteratorInterface<T> {
	/** Returns true if the iteration has more elements. 
    @return true if the iteration has more elements */
	public boolean hasNext();
	/** Retrieves the next entry in the collection and
	advances this iterator by one position.
	@return a reference to the next entry in the iteration,
	if one exists
	@throws NoSuchElementException if the iterator had reached the
	end already, that is, if hasNext() is false */
	public T next();
}
