package ludugz.simplegithubclient.common

interface Converter<T, K> {
    fun convert(content: T): K
}