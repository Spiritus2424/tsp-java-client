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
	public List<Bookmark> getBookmarks(UUID experimentUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark getBookmark(UUID experimentUuid, UUID bookmarkUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark createBookmark(UUID experimentUuid, Bookmark bookmark) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark updateBookmark(UUID experimentUuid, UUID bookmarkUuid, Bookmark bookmark) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Async
	public Bookmark deleteBookmark(UUID experimentUuid, UUID bookmarkUuid) {
		throw new UnsupportedOperationException("Not Implemented");
	}
}
