module.exports = {
  cache: {
    cacheId: "instalura-ssr2",
    runtimeCaching: [{
      handler: "fastest",
      urlPattern: "\/$"
    }],
    staticFileGlobs: ['dist/**/*']
  },
  manifest: {
    background: "#FFFFFF",
    title: "instalura-ssr2",
    short_name: "PWA",
    theme_color: "#FFFFFF"
  }
};
