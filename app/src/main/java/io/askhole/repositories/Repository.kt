package io.askhole.repositories

abstract class Repository {
    interface Callback<T> {
        fun onFinished(
            status: Status,
            response: T?
        )
    }

    class Result<T>(val status: Status, val data: T?)

    interface Error {
        val code: String?
        val message: String?
    }

    open class GenericError(override val code: String, override val message: String) :
        Error

    class TimestampError : GenericError("WRONG_TIMESTAMP", "WRONG_TIMESTAMP")

    class Status(
        val isSuccess: Boolean,
        val isOngoing: Boolean,
        val source: Source,
        val error: Error?
    ) {

        companion object {
            fun createSuccess(source: Source): Status {
                return Status(true, false, source, null)
            }

            fun createSuccess(
                source: Source,
                ongoing: Boolean
            ): Status {
                return Status(true, ongoing, source, null)
            }

            fun createError(
                code: String,
                message: String
            ): Status {
                return Status(
                    false,
                    false,
                    Source.NO_SOURCE,
                    GenericError(code, message)
                )
            }

            fun createError(error: Error?): Status {
                return Status(
                    false,
                    false,
                    Source.NO_SOURCE,
                    error
                )
            }
        }

    }

    enum class Source {
        CACHE, DB, REMOTE, NO_SOURCE
    }

    abstract fun invalidate()
    class EmptyResponseError : Error {
        override val code: String?
            get() = "EMPTY_RESPONSE"

        override val message: String?
            get() = "Response is empty"
    }

    class ParsingError(override val message: String) :
        Error {
        override val code: String?
            get() = "PARSING_ERROR"

    }
}