package annotation;

public @interface Uniqueness {
	Constraints constraint() default @Constraints(unique = false);
}
