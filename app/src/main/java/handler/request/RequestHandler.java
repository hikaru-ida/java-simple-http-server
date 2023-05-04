package handler.request;

import base.data.Request;
import base.exception.NioHttpServerException;
import fj.data.Option;
import handler.HttpServerHandler;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RequestHandler implements HttpServerHandler<ByteBuffer, Option<Request>> {
    //private static final Pattern PATTERN = Pattern.compile("(?<method>.*) (?<path>.*?) (?<version>.*?)");
    private static final Pattern PATTERN =
            Pattern.compile("(?<method>.*) (?<path>.*?) (?<version>.*?)");

    private final Charset charset;

    public RequestHandler() {
        this.charset = Charset.forName("UTF-8");
    }

    @Override
    public Option<Request> apply(ByteBuffer buf) throws NioHttpServerException {
        CharBuffer decoded = charset.decode(buf);
        Matcher matcher = PATTERN.matcher(decoded);

        if (!matcher.find()) {
            return Option.none();
        }

        return Option.some(
                 new Request(matcher.group("method"), matcher.group("path"), matcher.group("version"))
        );
    }
}
