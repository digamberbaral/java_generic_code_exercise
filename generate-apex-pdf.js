const puppeteer = require('puppeteer');
const path = require('path');

(async () => {
  console.log('🚀 Launching browser...');
  const browser = await puppeteer.launch({ headless: true });
  const page = await browser.newPage();

  const htmlPath = path.resolve(__dirname, 'APEX_PROTOCOL_v2_Hybrid_Plan.html');
  const pdfPath = path.resolve(__dirname, 'APEX_PROTOCOL_v2_Hybrid_Plan.pdf');

  console.log('📄 Loading HTML file...');
  await page.goto(`file:///${htmlPath.replace(/\\/g, '/')}`, {
    waitUntil: 'networkidle0',
    timeout: 60000
  });

  // Wait for fonts to load
  await page.evaluateHandle('document.fonts.ready');

  // Remove animations and fixed elements for PDF (they don't render well in print)
  await page.evaluate(() => {
    // Remove particles (not visible in PDF)
    const particles = document.getElementById('particles');
    if (particles) particles.remove();

    // Remove scroll-to-top button
    const scrollBtn = document.getElementById('scrollTop');
    if (scrollBtn) scrollBtn.remove();

    // Remove sticky nav (fixed positioning breaks in PDF)
    const nav = document.querySelector('.nav');
    if (nav) nav.style.position = 'relative';

    // Disable all animations for clean PDF
    const style = document.createElement('style');
    style.textContent = `
      *, *::before, *::after {
        animation: none !important;
        transition: none !important;
      }
      .particles, .particle { display: none !important; }
      .scroll-top { display: none !important; }
      body { background: #0a0a0a !important; }
      .nav { position: relative !important; backdrop-filter: none !important; }
      
      /* Make all hidden elements visible for PDF */
      .day-block, .mini-card, .philo-card, .kot-step, .nutr-card, .info-box, .warn-box, .kot-box {
        opacity: 1 !important;
        transform: none !important;
      }

      /* Ensure full-width content usage — NO white margins */
      .page { max-width: 100% !important; padding: 0 16px !important; margin: 0 !important; }
      .hero { padding: 30px 16px 24px !important; margin: 0 !important; }
      .section { padding: 24px 0 !important; margin: 0 !important; border-bottom-color: #2a2a2a !important; }
      body { margin: 0 !important; padding: 0 !important; background: #0a0a0a !important; }
      html { margin: 0 !important; padding: 0 !important; }
      
      /* Remove any border/outline that creates white lines */
      @page { margin: 0; padding: 0; }
      .nav { margin: 0 !important; border: none !important; }
      
      /* Better page break handling */
      .day-block { page-break-inside: avoid; break-inside: avoid; margin-bottom: 16px !important; }
      .phase-header { page-break-after: avoid; break-after: avoid; }
      .section { page-break-before: auto; }
      .exercise-section { page-break-inside: avoid; break-inside: avoid; }
      .mini-card { page-break-inside: avoid; break-inside: avoid; }
      .col2, .col3 { page-break-inside: avoid; break-inside: avoid; }
      table { page-break-inside: avoid; break-inside: avoid; }
      
      /* Ensure grid layouts use full width */
      .week-grid { grid-template-columns: repeat(7, 1fr) !important; gap: 8px !important; }
      .col2 { grid-template-columns: 1fr 1fr !important; }
      .col3 { grid-template-columns: 1fr 1fr 1fr !important; }
      .philosophy-grid { grid-template-columns: repeat(3, 1fr) !important; }
      .nutrition-grid { grid-template-columns: repeat(4, 1fr) !important; }
      .kot-steps-grid { grid-template-columns: repeat(4, 1fr) !important; }
      
      /* Slightly smaller fonts for PDF density */
      body { font-size: 13px !important; }
      .day-block-title { font-size: 18px !important; }
      .section-title { font-size: 36px !important; }
      .phase-title { font-size: 30px !important; }
      td { font-size: 11px !important; padding: 6px 8px !important; }
      th { font-size: 9px !important; }
      .info-box, .warn-box, .kot-box { font-size: 11px !important; padding: 10px 14px !important; margin: 10px 0 !important; }
      .mini-card li { font-size: 11px !important; }
      .philo-card p { font-size: 11px !important; }
      
      /* Links in PDF - show URL style */
      a { color: #1fb8a3 !important; }
    `;
    document.head.appendChild(style);
  });

  // Small delay for styles to apply
  await new Promise(r => setTimeout(r, 1000));

  console.log('📐 Generating A4 PDF (full page, no margins, no borders)...');
  await page.pdf({
    path: pdfPath,
    format: 'A4',
    printBackground: true,
    margin: {
      top: '0mm',
      bottom: '0mm',
      left: '0mm',
      right: '0mm'
    },
    displayHeaderFooter: false,
    preferCSSPageSize: false
  });

  await browser.close();
  console.log(`\n✅ PDF generated successfully!`);
  console.log(`📁 Location: ${pdfPath}`);
  console.log(`📏 Format: A4 (210mm × 297mm)`);
  console.log(`📖 Full-page content with dark theme preserved`);
})();





