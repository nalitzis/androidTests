
@interface MyAnnotation {
	
	String title() default "N/A";
	String description() default "";
	int version() default 1;
}