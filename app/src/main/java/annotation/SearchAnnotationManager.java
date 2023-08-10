package annotation;

public class SearchAnnotationManager {

    private volatile static SearchAnnotationManager instance = null;

    public static SearchAnnotationManager getInstance() {
        if (instance == null) {
            synchronized (SearchAnnotationManager.class) {
                if (instance == null) {
                    instance = new SearchAnnotationManager();
                }
            }
        }
        return instance;
    }

    /**
     * 根据type获取到对应的class
     *
     * @param type
     * @return
     */
    public SearchEnum getSearchEnum(String type) {
        for (int i = 0; i < SearchEnum.values().length; i++) {
            Class<?> fragmentClass = SearchEnum.values()[i].getClazz();
            Search annotation = fragmentClass.getAnnotation(Search.class);
            if (annotation != null && annotation.searchenum().type.equals(type)) {
                return annotation.searchenum();
            }
        }
        return null;
    }
}
