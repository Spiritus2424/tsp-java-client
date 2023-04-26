package org.eclipse.tsp.java.client.api.bookmark;

import java.util.List;
import java.util.UUID;

import org.eclipse.annotationprocessor.async.Async;
import org.eclipse.tsp.java.client.api.AbstractTspApi;

public class BookmarkApi extends AbstractTspApi {
	private final String BOOKMARK_API_URL;

	public BookmarkApi(String baseUrl) {
		super(baseUrl);
		this.BOOKMARK_API_URL = this.getBaseUrl().concat("/experiments/{expUUID}/bookmarks");
	}

	@Async
	public List<Bookmark> getBookmarks(final UUID experimentUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark getBookmark(final UUID experimentUuid, final UUID bookmarkUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark createBookmark(final UUID experimentUuid, final Bookmark bookmark) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark updateBookmark(final UUID experimentUuid, final UUID bookmarkUuid, final Bookmark bookmark) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark deleteBookmark(final UUID experimentUuid, final UUID bookmarkUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}
}
